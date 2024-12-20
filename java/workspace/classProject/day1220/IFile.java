package day1220;

/**
 * 파일 인터페이스
 */
public interface IFile {
	public class FileInfo {
		public String fileName;
		public String fileExtension;
		public int fileSize;
		public String fileOwner;
		public String filePath;
		public String baseApp;

		public FileInfo() {
		}

		public FileInfo(String fileName, String fileExtension, int fileSize, String fileOwner, String filePath, String baseApp) {
			this.fileName = fileName;
			this.fileExtension = fileExtension;
			this.fileSize = fileSize;
			this.fileOwner = fileOwner;
			this.filePath = filePath;
			this.baseApp = baseApp;
		}
	}

	FileInfo getFileInfo();

	void modifyFile(FileInfo fileInfo);

	void modifyFile(String fileName, String fileExtension, int fileSize, String fileOwner, String filePath, String baseApp);

	void deleteFile();
}
