package glyj_paper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * FileString
 * http://ask.csdn.net/questions/375147?sort=comments_count
 * @author littlehow
 * @time 2017-03-30 19:03
 */
public final class FileNameSort implements Comparable<FileNameSort> {
    private final String fileName;
    private final int prefix_num;
    Pattern number = Pattern.compile("(\\d+)\\..*");

    public FileNameSort(String fileName) {
        this.fileName = fileName;
        Matcher matcher = number.matcher(fileName);
        if (matcher.find()) {
            prefix_num = Integer.parseInt(matcher.group(1));
        } else {
            prefix_num = 0;
        }
    }

    @Override
    public int compareTo(FileNameSort o) {
        return o.prefix_num > prefix_num ? -1 : o.prefix_num == prefix_num ? 0 : 1; 
    }

    @Override
    public String toString() {
        return fileName;
    }
}