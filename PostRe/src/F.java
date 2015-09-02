import java.io.IOException;

import net.iharder.Base64;

public class F {
	public static void main(String[] args) throws IOException {
		byte[] a = Base64.decode("L3Nob3BwaW5nL2NvbmZpcm0uYWN0aW9uP2lkPTEmbmFtZT1pdHpoYWk=");
		String url = new String(a);
		System.out.println(url);
	}
}
