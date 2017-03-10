package framework.testcase.one;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ValidateTitle title = new ValidateTitle();
		title.openBrowser("firefox");
		
		
		
		int[] linknos = {2938, 1179, 562, 1633, 2961, 891, 2941, 2963};
		
		String prefix = "catnav-primary-link-";
		String suffix = "-link";
		
		String[] xpath = new String[linknos.length];
		
		for (int i=0; i<linknos.length; i++) {
			xpath[i] = prefix + linknos[i] + suffix;
		}
		
		if (title.validatePage("https://www.etsy.com/", "Etsy.com | Shop for anything from creative people everywhere")) {
			for (int i=0; i<xpath.length; i++) {
				if (title.validateLink(xpath[i], "Vintage")) {
					System.out.println("Testcase " + i + ": Passed");
				} else {
					System.out.println("Testcase " + i + ": Failed");
				}
			}
		}
		
		title.closeBrowser();
	}

}
