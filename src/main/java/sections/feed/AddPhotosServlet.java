package sections.feed;

import model.entities.Photo;
import org.hibernate.Session;
import org.imgscalr.Scalr;
import utils.HibernateUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.bind.DatatypeConverter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

@MultipartConfig
public class AddPhotosServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathToImageFolder = getInitParameter("pathToImageFolder") + File.separator;
        Part part = req.getPart("image");
        if(part==null) {
            System.out.println("fuck");
        }

        String imageName = getFileName(part) + System.currentTimeMillis();

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(imageName.getBytes());
        byte[] digest = md.digest();
        imageName = DatatypeConverter.printHexBinary(digest).toUpperCase();


        File imageFile = new File(pathToImageFolder + imageName);

        try (OutputStream out = new FileOutputStream(imageFile);
             InputStream fileContent = part.getInputStream()) {
            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = fileContent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            BufferedImage actualImage = ImageIO.read(imageFile); //it'll be deleted in the end

            //converting all images to jpg
            BufferedImage actualImageToJPG = new BufferedImage(actualImage.getWidth(),
                    actualImage.getHeight(), BufferedImage.TYPE_INT_RGB);
            actualImageToJPG.createGraphics().drawImage(actualImage, 0, 0, Color.WHITE, null);

            //lossless compression of image
            BufferedImage smallerInSizeActualImageToJPG = Scalr.resize(actualImageToJPG,
                    Scalr.Method.ULTRA_QUALITY,
                    actualImageToJPG.getWidth(),
                    actualImageToJPG.getHeight()/*,
                    Scalr.OP_ANTIALIAS*/);

            //getting thumbnail of an image with the biggest possible size of side 1500
            BufferedImage thumbnail = Scalr.resize(actualImageToJPG,
                    Scalr.Method.ULTRA_QUALITY,
                    1500,
                    1500);

            //calculating the left upper corner's coordinates
            int x1,y1;
            if(thumbnail.getWidth() > thumbnail.getHeight()) {
                x1 = thumbnail.getWidth()/2-thumbnail.getHeight()/2;
                y1 = 0;
            }
            else {
                x1 = 0;
                y1 = thumbnail.getHeight()/2 - thumbnail.getWidth()/2;
            }

            //getting the square thumbnail
            BufferedImage squareImage = thumbnail;
            squareImage = Scalr.crop(squareImage, x1, y1,
                    Math.min(thumbnail.getWidth(),thumbnail.getHeight()),
                    Math.min(thumbnail.getWidth(),thumbnail.getHeight()));

            //getting names of images

            String originalPhotoName = imageName + "_original" +
                    smallerInSizeActualImageToJPG.getWidth() + "x" + smallerInSizeActualImageToJPG.getHeight() + ".jpg";
            String thumbnailPhotoName = imageName + "_thumb" + thumbnail.getWidth() + "x" + thumbnail.getHeight() + ".jpg";
            String squareThumbnailName = imageName + "_square" + squareImage.getWidth() + "x" + squareImage.getHeight() + ".jpg";

            //saving the images
            ImageIO.write(smallerInSizeActualImageToJPG, "jpg",
                    new File(pathToImageFolder + originalPhotoName));
            ImageIO.write(thumbnail, "jpg",
                    new File(pathToImageFolder + thumbnailPhotoName));
            ImageIO.write(squareImage, "jpg",
                    new File(pathToImageFolder + squareThumbnailName));

            Photo smallerInSizeActualImageToJPGPhoto = new Photo(originalPhotoName,
                                                                thumbnailPhotoName,
                                                                squareThumbnailName,
                                                                new Timestamp(System.currentTimeMillis()),
                                                                null);

            Session hibSession = HibernateUtil.getSessionFactory().openSession();
            hibSession.beginTransaction();
            hibSession.persist(smallerInSizeActualImageToJPGPhoto);
            hibSession.getTransaction().commit();
            hibSession.close();

        }
        catch (FileNotFoundException fne) {
            fne.printStackTrace();
        }

        //deleting the original uploaded image, because we now have the compressed one, which weights less
        imageFile.delete();
    }

    private String getFileName(final Part part) {
        //final String partHeader = part.getHeader("content-disposition");
        //LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}