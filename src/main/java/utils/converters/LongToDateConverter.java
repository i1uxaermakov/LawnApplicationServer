package utils.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;

@Converter(autoApply=true)
public class LongToDateConverter implements AttributeConverter<Timestamp,Long> {
    @Override
    public Long convertToDatabaseColumn(Timestamp timestamp) {
        return timestamp.getTime();
    }

    @Override
    public Timestamp convertToEntityAttribute(Long aLong) {
        return new Timestamp(aLong);
    }
}
