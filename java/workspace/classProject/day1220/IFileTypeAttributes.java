package day1220;

public interface IFileTypeAttributes {
	public class AudioFileInfo {
		public String author;
		public int bitRate;
		public int audioLength;
		public String title;

		public AudioFileInfo() {
		}

		public AudioFileInfo(String author, int bitRate, int audioLength, String title) {
			this.author = author;
			this.bitRate = bitRate;
			this.audioLength = audioLength;
			this.title = title;
		}
	}

	public class VideoFileInfo {
		public String title;
		public String description;
		public int videoLength;
		public int frameWidth;
		public int frameHeight;
		public int totalBitRate;
		public int frame;

		public VideoFileInfo() {
		}

		public VideoFileInfo(String title, String description, int videoLength, int frameWidth, int frameHeight, int totalBitRate, int frame) {
			this.title = title;
			this.description = description;
			this.videoLength = videoLength;
			this.frameWidth = frameWidth;
			this.frameHeight = frameHeight;
			this.totalBitRate = totalBitRate;
			this.frame = frame;
		}
	}
}
