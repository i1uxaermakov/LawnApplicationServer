package sections.feed.posts;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sections.feed.posts.entities.Post;
import utils.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Set;

@MultipartConfig
public class AddFilesServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long postId = new Long(req.getParameter("postId"));
        Session hibSession = HibernateUtil.getSessionFactory().openSession();
        Post post = hibSession.get(Post.class,postId);

        if(post!=null) {
            Part part = req.getPart("file");
            String fileName = getFileName(part);

            try (   OutputStream out = new FileOutputStream(new File("/Users/ilya_ermakov/Desktop/files" + File.separator + fileName));
                    InputStream fileContent = part.getInputStream()) {
                int read = 0;
                final byte[] bytes = new byte[1024];

                while ((read = fileContent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
            }
            catch (FileNotFoundException fne) {
                fne.printStackTrace();
            }

            utils.files.File file = new utils.files.File();
            file.setLocation("/Users/ilya_ermakov/Desktop/files" + File.separator + fileName);
            file.setSize(part.getSize());
            //file.setPost(post);

            Set<utils.files.File> fileSet= post.getFiles();
            fileSet.add(file);
            post.setFiles(fileSet);

        }
        Transaction transaction = hibSession.beginTransaction();
        hibSession.update(post);
        transaction.commit();

        hibSession.flush();
        hibSession.close();

        //todo logging everywhere
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