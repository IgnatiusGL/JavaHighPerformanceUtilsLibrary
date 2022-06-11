package top.ignatiusgl.net;

import top.ignatiusgl.exception.IllegalParameterException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Description: Encapsulates a tool for manipulating HTML source code
 * @author: IgnatiusGL
 * @date: 2022-06-11 10:52
 */
public class HTML {
    private String sourceCode;
    private final Pattern pattern = Pattern.compile("class=\"[a-z\\s_+\\-/~]+\"");

    // The select type, such as id selector and class selector
    public enum NameTypeEnum {
        CLASS_NAME,
        ID,
    }

    public HTML(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    /**
     * Get the string of source code
     *
     * @return source code
     */
    public String getSourceCode() {
        return sourceCode;
    }

    public HTML div(String name) {
        NameTypeEnum type = getSelectorType(name);
        List<String> div = getContent("div", type, name.substring(1));
        StringBuilder sb = new StringBuilder();
        for (String s : div) {
            sb.append(s).append("\n");
        }
        sourceCode = sb.toString();
        return this;
    }

    public HTML p(String name) {
        NameTypeEnum type = getSelectorType(name);
        List<String> p = getContent("p", type, name.substring(1));
        StringBuilder sb = new StringBuilder();
        for (String s : p) {
            sb.append(s).append("\n");
        }
        sourceCode = sb.toString();
        return this;
    }

    public HTML h1(String name) {
        NameTypeEnum type = getSelectorType(name);
        List<String> h1 = getContent("h1", type, name.substring(1));
        StringBuilder sb = new StringBuilder();
        for (String s : h1) {
            sb.append(s).append("\n");
        }
        sourceCode = sb.toString();
        return this;
    }

    /**
     * Remove all tag in source code
     * @return content without tag
     */
    public String removeAllTag() {
        return sourceCode.replaceAll("<[a-z0-9\\s\\\"\\-/=+~]+>", "");
    }

    public List<HTML> tag(String name) {
        List<String> contentByTagName = getContentByTagName(name);
        return contentByTagName.stream().parallel().map(HTML::new).collect(Collectors.toList());
    }

    private NameTypeEnum getSelectorType(String name) {
        NameTypeEnum type = null;
        if (name.startsWith(".")) {
            type = NameTypeEnum.CLASS_NAME;
        } else if (name.startsWith("#")) {
            type = NameTypeEnum.ID;
        } else {
            throw new IllegalParameterException("Illegal selector type");
        }
        return type;
    }



    /**
     * Get the content by tag name type and selector
     * @return return string list of result
     */
    private List<String> getContent(String tag, NameTypeEnum type, String selector) {
        List<String> result = new ArrayList<>();
        char[] chars = sourceCode.toCharArray();
        boolean startRecord = false;
        boolean startRecordContent = false;
        StringBuilder tagSb = new StringBuilder();
        int count = 0;
        int startIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '<') {
                startRecord = true;
            } else if (chars[i] == '>') {
                startRecord = false;
                tagSb.append(chars[i]);
                String tagString = tagSb.toString();
                tagSb = new StringBuilder();
                if (tagString.startsWith("<" + tag)) {
                    if (type == NameTypeEnum.ID && tagString.contains("id=\"" + selector + "\"")) {
                        startIndex = i - tagString.length()  + 1;
                        startRecordContent = true;
                    } else if (type == NameTypeEnum.CLASS_NAME) {
                        Matcher matcher = pattern.matcher(tagString);
                        if (matcher.find() && matcher.group().contains(selector)) {
                            startIndex = i - tagString.length() + 1;
                            startRecordContent = true;
                        }
                    }
                    if (startRecordContent) {
                        count++;
                    }
                } else if (startRecordContent && tagString.startsWith("</" + tag + ">")) {
                    count--;
                    if (count == 0) {
                        startRecordContent = false;
                        result.add(sourceCode.substring(startIndex, i + 1));
                        startIndex = 0;
                    }
                }
            }
            if (startRecord) {
                tagSb.append(chars[i]);
            }
        }
        return result;
    }

    private List<String> getContentByTagName(String tag) {
        List<String> result = new ArrayList<>();
        char[] chars = sourceCode.toCharArray();
        boolean startRecord = false;
        boolean startRecordContent = false;
        boolean firstTag = true;
        StringBuilder tagSb = new StringBuilder();
        int count = 0;
        int startIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '<') {
                startRecord = true;
            } else if (chars[i] == '>') {
                startRecord = false;
                tagSb.append(chars[i]);
                String tagString = tagSb.toString();
                tagSb = new StringBuilder();
                if (firstTag) {
                    firstTag = false;
                    continue;
                }
                if (!startRecordContent && tagString.startsWith("<" + tag)) {
                    startRecordContent = true;
                    startIndex = i - tagString.length() + 1;
                    count++;
                } else if (startRecordContent && tagString.startsWith("</" + tag + ">")) {
                    count--;
                    if (count == 0) {
                        startRecordContent = false;
                        result.add(sourceCode.substring(startIndex, i + 1));
                        startIndex = 0;
                    }
                }
            }
            if (startRecord) {
                tagSb.append(chars[i]);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "HTML{" +
                "sourceCode='" + sourceCode + '\'' +
                '}';
    }
}
