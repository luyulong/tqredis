import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import net.iharder.Base64;

/**
 * @author xing
 */
public class TestBase64 {
	public static void main(String[] args) {
		byte[] data = compress(loadFile());
		String json = new String(Base64.encodeBytes(data));
		System.out.println("data length:" + json.length());
	}

	/**
	 * 加载本地文件,并转换为byte数组
	 * 
	 * @return
	 */
	public static byte[] loadFile() {
		File file = new File("E:/天阙培训资料/内存管理/IMG_0022.JPG");

		FileInputStream fis = null;
		ByteArrayOutputStream baos = null;
		byte[] data = null;

		try {
			fis = new FileInputStream(file);
			baos = new ByteArrayOutputStream((int) file.length());

			byte[] buffer = new byte[1024];
			int len = -1;
			while ((len = fis.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}

			data = baos.toByteArray();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
					fis = null;
				}

				baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return data;
	}

	/**
	 * 对byte[]进行压缩
	 * 
	 * @param 要压缩的数据
	 * @return 压缩后的数据
	 */
	public static byte[] compress(byte[] data) {
		System.out.println("before:" + data.length);

		GZIPOutputStream gzip = null;
		ByteArrayOutputStream baos = null;
		byte[] newData = null;

		try {
			baos = new ByteArrayOutputStream();
			gzip = new GZIPOutputStream(baos);

			gzip.write(data);
			gzip.finish();
			gzip.flush();

			newData = baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				gzip.close();
				baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("after:" + newData.length);
		return newData;
	}
}