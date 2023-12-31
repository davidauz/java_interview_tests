package constructs.generics;

import java.nio.file.Path;

public class data_audio extends data_basic {
	private Path m_path_to_audio_file;
	public data_audio(Path p) { m_path_to_audio_file=p; }

	@Override
	public void show() {
		System.out.println("Playing audio from `"+m_path_to_audio_file+"`\n");
	}
}
