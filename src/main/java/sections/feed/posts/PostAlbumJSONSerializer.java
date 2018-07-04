package sections.feed.posts;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import sections.feed.posts.entities.PostAlbum;

import java.io.IOException;

public class PostAlbumJSONSerializer extends StdSerializer<PostAlbum> {
    public PostAlbumJSONSerializer(Class<PostAlbum> t) {
        super(t);
    }

    public PostAlbumJSONSerializer() {
        this(null);
    }

    @Override
    public void serialize(PostAlbum postAlbum, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        int albumSize = postAlbum.getAlbumPhotos().size();
        jsonGenerator.writeNumberField("albumSize", albumSize);
        if(albumSize<4) {
            jsonGenerator.writeObjectField("albumPhotos", postAlbum.getAlbumPhotos());
        }
        else {
            jsonGenerator.writeStringField("mainPhotoLocation", postAlbum.getMainPhotoLocation());
        }
        jsonGenerator.writeEndObject();
    }
}

/*
    private Long postId;
    private Post post;
    private String mainPhotoLocation;
    private Set<Photo> albumPhotos = new HashSet<>(0);
*/
