package day1220;

/**
 * 비디오 클래스
 */
public class VideoFile extends File implements IFileTypeAttributes {
	private VideoFileInfo videoFileInfo;

	public VideoFile() {
		super(null, null);
		this.videoFileInfo = null;
	}

	public VideoFile(VideoFileInfo videoFileInfo) {
		super(null, null);
		this.videoFileInfo = videoFileInfo;
	}

	public VideoFile(VideoFileInfo videoFileInfo, FileInfo fileInfo) {
		super(fileInfo, null);
		this.videoFileInfo = videoFileInfo;
	}

	public VideoFile(VideoFileInfo videoFileInfo, FileAttributesInfo fileAttrInfo) {
		super(null, fileAttrInfo);
		this.videoFileInfo = videoFileInfo;
	}

	public VideoFile(VideoFileInfo videoFileInfo, FileInfo fileInfo, FileAttributesInfo fileAttrInfo) {
		super(fileInfo, fileAttrInfo);
		this.videoFileInfo = videoFileInfo;
	}

	public VideoFileInfo getVideoFileInfo() {
		return videoFileInfo;
	}

	public void setVideoFileInfo(VideoFileInfo videoFileInfo) {
		this.videoFileInfo = videoFileInfo;
	}

	public String getTitle() {
		return this.videoFileInfo.title;
	}

	public void setTitle(String title) {
		this.videoFileInfo.title = title;
	}

	public String getDescription() {
		return this.videoFileInfo.description;
	}

	public void setDescription(String description) {
		this.videoFileInfo.description = description;
	}

	public int getVideoLength() {
		return this.videoFileInfo.videoLength;
	}

	public void setVideoLength(int videoLength) {
		this.videoFileInfo.videoLength = videoLength;
	}

	public int getFrameWidth() {
		return this.videoFileInfo.frameWidth;
	}

	public void setFrameWidth(int frameWidth) {
		this.videoFileInfo.frameWidth = frameWidth;
	}

	public int getFrameHeight() {
		return this.videoFileInfo.frameHeight;
	}

	public void setFrameHeight(int frameHeight) {
		this.videoFileInfo.frameHeight = frameHeight;
	}

	public int getTotalBitRate() {
		return this.videoFileInfo.totalBitRate;
	}

	public void setTotalBitRate(int totalBitRate) {
		this.videoFileInfo.totalBitRate = totalBitRate;
	}

	public int getFrame() {
		return this.videoFileInfo.frame;
	}

	public void setFrame(int frame) {
		this.videoFileInfo.frame = frame;
	}

	@Override
	public void writeFileInfo() {
		VideoFileInfo video = this.videoFileInfo;
		FileInfo file = this.getFileInfo();
		FileAttributesInfo attr = this.getFileAttributes();
		if (file == null || attr == null) {
			System.out.println("파일을 읽을 수 없음");
			return;
		}
		System.out.println("비디오" + "-".repeat(49));
		System.out.println("제목\t\t| " + video.title);
		System.out.println("설명\t\t| " + video.description);
		System.out.printf("길이\t\t| %02d:%02d:%02d\n", video.videoLength / 3600, (video.videoLength % 3600) / 60, ((video.videoLength % 3600) % 60));
		System.out.println("총 비트전송률\t| " + video.totalBitRate);
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
