package day1220;

/**
 * 오디오 클래스
 */
public class AudioFile extends File implements IFileTypeAttributes {
	private AudioFileInfo audioFileInfo;

	public AudioFile() {
		super(null, null);
		this.audioFileInfo = null;
	}

	public AudioFile(AudioFileInfo audioFileInfo) {
		super(null, null);
		this.audioFileInfo = audioFileInfo;
	}

	public AudioFile(AudioFileInfo audioFileInfo, FileInfo fileInfo) {
		super(fileInfo, null);
		this.audioFileInfo = audioFileInfo;
	}

	public AudioFile(AudioFileInfo audioFileInfo, FileAttributesInfo fileAttrInfo) {
		super(null, fileAttrInfo);
		this.audioFileInfo = audioFileInfo;
	}

	public AudioFile(AudioFileInfo audioFileInfo, FileInfo fileInfo, FileAttributesInfo fileAttrInfo) {
		super(fileInfo, fileAttrInfo);
		this.audioFileInfo = audioFileInfo;
	}

	public AudioFileInfo getAudioFileInfo() {
		return this.audioFileInfo;
	}

	public void setAudioFileInfo(AudioFileInfo audioFileInfo) {
		this.audioFileInfo = audioFileInfo;
	}

	public String getAuthor() {
		return this.audioFileInfo.author;
	}

	public void setAuthor(String author) {
		this.audioFileInfo.author = author;
	}

	public int getBitRate() {
		return this.audioFileInfo.bitRate;
	}

	public void setBitRate(int bitRate) {
		this.audioFileInfo.bitRate = bitRate;
	}

	public int getAudioLength() {
		return this.audioFileInfo.audioLength;
	}

	public void setAudioLength(int audioLength) {
		this.audioFileInfo.audioLength = audioLength;
	}

	public String getTitle() {
		return this.audioFileInfo.title;
	}

	public void setTitle(String title) {
		this.audioFileInfo.title = title;
	}

	@Override
	public void writeFileInfo() {
		AudioFileInfo audio = this.audioFileInfo;
		FileInfo file = this.getFileInfo();
		FileAttributesInfo attr = this.getFileAttributes();
		if (file == null || attr == null) {
			System.out.println("파일을 읽을 수 없음");
			return;
		}
		System.out.println("오디오" + "-".repeat(49));
		System.out.println("제목\t\t| " + audio.title);
		System.out.println("작곡가\t\t| " + audio.author);
		System.out.printf("길이\t\t| %02d:%02d:%02d\n", audio.audioLength / 3600, (audio.audioLength % 3600) / 60, ((audio.audioLength % 3600) % 60));
		System.out.println("비트전송률\t\t| " + audio.bitRate);
		System.out.println("파일" + "-".repeat(50));
		System.out.println("파일명\t\t| " + file.fileName);
		System.out.println("파일형식\t\t| " + attr.fileType.toString() + "(" + file.fileExtension + ")");
		System.out.println("연결 프로그램\t| " + file.baseApp);
		System.out.println("위치\t\t| " + file.filePath);
		System.out.println("파일 크기\t\t| " + file.fileSize);
		System.out.println("만든 날짜\t\t| " + attr.createdDate.toString());
		System.out.println("수정한 날짜\t\t| " + attr.modifiedDate.toString());
		System.out.println("액세스한 날짜\t| " + attr.accessDate.toString());
		System.out.println("소유자\t\t| " + file.fileOwner);
	}
}
