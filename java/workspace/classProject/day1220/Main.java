package day1220;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import day1220.IFileTypeAttributes.*;
import day1220.IFile.FileInfo;
import day1220.IFileAttributes.FileAttributesInfo;

public class Main {
	public static void main(String[] args) {
		List<AudioFile> audioList = new ArrayList<AudioFile>();
		List<VideoFile> videoList = new ArrayList<VideoFile>();
		AudioFileInfo audioInfo;
		VideoFileInfo videoInfo;
		FileInfo fileInfo;
		FileAttributesInfo fileAttr;

		audioInfo = new AudioFileInfo("Bob Acri", 192, 200, "Sleep Away");
		fileInfo = new FileInfo("노래1", ".mp3", 4731, "bitcamp\\bit", "C:\\Users\\bit\\Downloads\\", "미디어 플레이어");
		fileAttr = new FileAttributesInfo(EFileType.MP3, LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now());
		audioList.add(new AudioFile(audioInfo, fileInfo, fileAttr));

		audioInfo = new AudioFileInfo("Chopin", 192, 760, "Grande Polonaise Heroic");
		fileInfo = new FileInfo("노래2", ".mp3", 14731, "bitcamp\\bit", "C:\\Users\\bit\\Downloads\\", "미디어 플레이어");
		fileAttr = new FileAttributesInfo(EFileType.MP3, LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now());
		audioList.add(new AudioFile(audioInfo, fileInfo, fileAttr));

		videoInfo = new VideoFileInfo("Ocean", "바닷가 동영상", 320, 1920, 1080, 25500, 30);
		fileInfo = new FileInfo("바다1", ".mp4", 59903, "bitcamp\\bit", "C:\\Users\\bit\\Downloads\\", "미디어 플레이어");
		fileAttr = new FileAttributesInfo(EFileType.MP4, LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now());
		videoList.add(new VideoFile(videoInfo, fileInfo, fileAttr));

		for (AudioFile audio : audioList) {
			audio.writeFileInfo();
			audio.modifyFile("변경됨", ".ba3f", 4903, "encryptUser", "C:\\Temp\\", null);
			audio.modifyFileAttributes(EFileType.NONE, audio.getFileAttributes().modifiedDate, audio.getFileAttributes().accessDate,
					audio.getFileAttributes().createdDate);
		}
		for (AudioFile audio : audioList) {
			audio.writeFileInfo();
		}
		System.out.println();
		for (VideoFile video : videoList) {
			video.writeFileInfo();
		}
	}
}
