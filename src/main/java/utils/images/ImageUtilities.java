package utils.images;

import org.imgscalr.Scalr;
import security.entities.User;
import utils.files.FileUtilities;

import javax.imageio.ImageIO;
import javax.servlet.http.Part;
import javax.xml.bind.DatatypeConverter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class ImageUtilities {
    public static Photo processReceivedImageAndGetPhotoEntity(Part part, String pathToImageFolder, String suffix, User user) {
        if (part == null) {
            return null;
        }
        Photo smallerInSizeActualImageToJPGPhoto = null;

        String imageName = FileUtilities.getFileName(part);
        if(imageName == null) {
            return null;
        }
        imageName += System.currentTimeMillis();

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(imageName.getBytes());
        byte[] digest = md.digest();
        imageName = DatatypeConverter.printHexBinary(digest).toUpperCase();


        File imageFile = new File(pathToImageFolder + File.separator + suffix + File.separator + imageName);

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
            int x1, y1;
            if (thumbnail.getWidth() > thumbnail.getHeight()) {
                x1 = thumbnail.getWidth() / 2 - thumbnail.getHeight() / 2;
                y1 = 0;
            } else {
                x1 = 0;
                y1 = thumbnail.getHeight() / 2 - thumbnail.getWidth() / 2;
            }

            //getting the square thumbnail
            BufferedImage squareImage = thumbnail;
            squareImage = Scalr.crop(squareImage, x1, y1,
                    Math.min(thumbnail.getWidth(), thumbnail.getHeight()),
                    Math.min(thumbnail.getWidth(), thumbnail.getHeight()));

            //getting dimensions of images
            String originalDim = smallerInSizeActualImageToJPG.getWidth() + "x" + smallerInSizeActualImageToJPG.getHeight();
            String thumbDim = thumbnail.getWidth() + "x" + thumbnail.getHeight();
            String squareDim = squareImage.getWidth() + "x" + squareImage.getHeight();

            //getting names of images
            String originalPhotoName = suffix + File.separator + imageName + "_original" + originalDim + ".jpg";
            String thumbnailPhotoName = suffix + File.separator + imageName + "_thumb" + thumbDim + ".jpg";
            String squareThumbnailName = suffix + File.separator + imageName + "_square" + squareDim + ".jpg";

            //saving the images
            ImageIO.write(smallerInSizeActualImageToJPG, "jpg",
                    new File(pathToImageFolder + File.separator + originalPhotoName));
            ImageIO.write(thumbnail, "jpg",
                    new File(pathToImageFolder + File.separator + thumbnailPhotoName));
            ImageIO.write(squareImage, "jpg",
                    new File(pathToImageFolder + File.separator + squareThumbnailName));

            smallerInSizeActualImageToJPGPhoto = new Photo(
                    originalPhotoName, originalDim,
                    thumbnailPhotoName, thumbDim,
                    squareThumbnailName, squareDim,
                    new Timestamp(System.currentTimeMillis()),
                    user.getFullName());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //deleting the original uploaded image, because we now have the compressed one, which weights less
        imageFile.delete();
        return smallerInSizeActualImageToJPGPhoto;
    }
}
