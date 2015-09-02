
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import org.apache.commons.codec.binary.Base64;


public class FileTransferUtil {
	
	public static void baseCodeTransferToFile(String fileName,String baseCodes) throws Exception{
		byte[] bytes = Base64.decodeBase64(baseCodes);
		for (int i = 0; i < bytes.length; ++i) {
			if (bytes[i] < 0) {// 调整异常数据
				bytes[i] += 256;
			}
		}
		OutputStream out = new FileOutputStream("C:\\Users\\wenqiang\\Desktop\\file\\image\\"+fileName);  
		out.write(bytes);  
		out.flush();  
		out.close(); 
	}
	
		
	public static HashMap<String, String> fileTransferToBaseCode(String[] fileNames) throws Exception{
		HashMap<String, String> fileBaseCode = new HashMap<String, String>();
		for(String fileName : fileNames){
			File file = getFileFromTmpFolder(fileName);
			String code  = getBaseCode(file);
			fileBaseCode.put(fileName, code);
		}
		return fileBaseCode;
	}
	
	
	public static String getWebRoot() throws RuntimeException {
		String path = FileUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		if (path.indexOf("WEB-INF") > 0) {
			path = path.substring(0, path.indexOf("WEB-INF") - 1);
		} else {
			throw new RuntimeException("路径获取错误");
		}
		return path;
	}
	
	private static File getFileFromTmpFolder(String fileName) {
		return new File(new StringBuffer("e:/").toString());
	}
	
	public static String getBaseCode(File file) throws Exception{
        byte[] bytes = null;
        if(file!=null)
        {
            InputStream is = new FileInputStream(file);
            int length = (int) file.length();
            bytes = new byte[length];
            int offset = 0;
            int numRead = 0;
            while(offset<bytes.length&&(numRead=is.read(bytes,offset,bytes.length-offset))>=0)
            {
                offset+=numRead;
            }
            is.close();
        }
        return Base64.encodeBase64URLSafeString(bytes);
    }
}
