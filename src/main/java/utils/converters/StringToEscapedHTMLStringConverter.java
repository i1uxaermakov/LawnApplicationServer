package utils.converters;

import org.apache.commons.text.StringEscapeUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=true)
public class StringToEscapedHTMLStringConverter implements AttributeConverter<String,String> {
    @Override
    public String convertToDatabaseColumn(String s) {
        return StringEscapeUtils.unescapeHtml4(s);
    }

    @Override
    public String convertToEntityAttribute(String s) {
        return StringEscapeUtils.escapeHtml4(s);
    }
}
