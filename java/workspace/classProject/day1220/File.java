package day1220;

import java.time.LocalDateTime;

/**
 * 파일 추상 클래스
 */
public abstract class File implements IFile, IFileAttributes {
	private FileInfo fileInfo;
	private FileAttributesInfo fileAttributesInfo;

	public File() {
		this.fileInfo = null;
		this.fileAttributesInfo = null;
	}

	public File(FileInfo file) {
		this.fileInfo = file;
		this.fileAttributesInfo = null;
	}

	public File(FileAttributesInfo fileAttr) {
		this.fileInfo = null;
		this.fileAttributesInfo = fileAttr;
	}

	public File(FileInfo file, FileAttributesInfo fileAttr) {
		this.fileInfo = file;
		this.fileAttributesInfo = fileAttr;
	}

	abstract public void writeFileInfo();

	@Override
	public FileAttributesInfo getFileAttributes() {
		return this.fileAttributesInfo;
	}

	@Override
	public void modifyFileAttributes(FileAttributesInfo fileAttributesInfo) {
		this.fileAttributesInfo = fileAttributesInfo;
	}

	@Override
	public void modifyFileAttributes(EFileType fileType, LocalDateTime modifiedDate, LocalDateTime accessDate, LocalDateTime createdDate) {
		FileAttributesInfo info = new FileAttributesInfo();
		info.fileType = fileType;
		info.modifiedDate = modifiedDate;
		info.accessDate = accessDate;
		info.createdDate = createdDate;
		this.fileAttributesInfo = info;
	}

	@Override
	public void deleteFileAttributes() {
		this.fileAttributesInfo = null;

	}

	@Override
	public FileInfo getFileInfo() {
		return this.fileInfo;
	}

	@Override
	public void modifyFile(FileInfo fileInfo) {
		this.fileInfo = fileInfo;

	}

	@Override
	public void modifyFile(String fileName, String fileExtension, int fileSize, String fileOwner, String filePath, String baseApp) {
		FileInfo info = new FileInfo();
		info.fileName = fileName;
		info.fileExtension = fileExtension;
		info.fileSize = fileSize;
		info.fileOwner = fileOwner;
		info.filePath = filePath;
		info.baseApp = baseApp;
		this.fileInfo = info;
	}

	@Override
	public void deleteFile() {
		this.fileInfo = null;
	}
}
