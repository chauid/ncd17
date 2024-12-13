public class Main {
	public static void main(String[] args) {
		String[] typeList = new String[args.length];
		for (int i = 0; i < args.length; i++) {
			try {
				Integer.parseInt(args[i]);
				typeList[i] = "Integer";
			} catch (Exception e) {
				typeList[i] = "String";
			}
		}
		System.out.print("¾È³çÇÏ¼¼¿ä ");
		for (int i = 0; i < args.length; i++) {
			if (i < args.length - 1) {
				if (typeList[i] == typeList[i + 1]) {
					int sum = Integer.parseInt(args[i]) + Integer.parseInt(args[i + 1]);
					System.out.print("(" + typeList[i] + ")" + sum + " ");
				} else {
					System.out.print(args[i] + args[i + 1] + " ");
				}
			} else {
				System.out.print(args[i]);
			}
		}
	}
}
