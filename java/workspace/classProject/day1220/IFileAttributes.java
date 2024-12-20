package day1220;

import java.time.LocalDateTime;

/**
 * 파일 속성 인터페이스
 */
public interface IFileAttributes {
	public class FileAttributesInfo {
		public EFileType fileType;
		public LocalDateTime modifiedDate;
		public LocalDateTime accessDate;
		public LocalDateTime createdDate;

		public FileAttributesInfo() {
		}

		public FileAttributesInfo(EFileType fileType, LocalDateTime modifiedDate, LocalDateTime accessDate, LocalDateTime createdDate) {
			this.fileType = fileType;
			this.modifiedDate = modifiedDate;
			this.accessDate = accessDate;
			this.createdDate = createdDate;
		}
	}

	FileAttributesInfo getFileAttributes();

	void modifyFileAttributes(FileAttributesInfo fileAttributesInfo);

	void modifyFileAttributes(EFileType fileType, LocalDateTime modifiedDate, LocalDateTime accessDate, LocalDateTime createdDate);

	void deleteFileAttributes();
}
