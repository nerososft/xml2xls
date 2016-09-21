package xls;

import jxl.write.Label;
import jxl.write.WritableSheet;

import java.io.File;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-20
 * time: 下午11:48.
 */
public interface IXlsDocument {
    public boolean in2xls(Label label);
}
