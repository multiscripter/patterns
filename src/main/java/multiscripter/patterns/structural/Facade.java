package multiscripter.patterns.structural;

/**
 * Фасад (Facade) - структурный шаблон проектирования.
 * Решает задачу простого использования системы
 * через предоставление упрощённого интерфейса.
 */

/**
 * Пример:
 * Медиа конвертер.
 * Дано:
 * Класс конвертера и несколько классов аудио и видео кодеков.
 * Задача:
 * Разработать класс-фасад, позволяющий конвертировать без необходимости
 * указывать множество настроек кодеков.
 */

/**
 * Избавляет от необходимости указывать все настройки.
 * Достаточно указать пресет. Является логическим фасадом для FullConverter.
 */
class LightConverter {
  private String preset;

  public LightConverter(String preset) {
    this.preset = preset;
  }

  public String convert(String filename) {
    AudioCodec aCodec = null;
    VideoCodec vCodec = null;
    switch (this.preset) {
      case "FullHD":
        aCodec = new MP3(384);
        vCodec = new MPEG4(5000, 1080, 1920);
        break;

      case "720p":
        aCodec = new MP3(192);
        vCodec = new MPEG4(2500, 720, 1280);
        break;
    }
    Settings conf = new Settings(aCodec, vCodec);
    FullConverter converter = new FullConverter(conf);
    return converter.convert(filename);
  }
}

/**
 * Класс-фасад, избавляющий клиента от небходимости явно инстанцировать
 * нужные классы и вызывать у них нужные методы.
 */
class FullConverter {
  private Settings conf;

  public FullConverter(Settings conf) {
    this.conf = conf;
  }

  public String convert(String filename) {
    /**
     * Здесь классы кодеков и другие классы делают свою работу. Что-то типа:
     * audioFile = conf.getAudioCodec().convert(audioFile);
     * audioFile = conf.getChannelConverter().convert(audioFile);
     * videoFile = conf.getVideoCodec().convert(videoFile);
     * File file = conf.getMixer().mix(audioFile, videoFile);
     */
    return String.format("File %s {settings: %s}", filename, this.conf.toString());
  }
}

// Класс настроек.
class Settings {
  private AudioCodec aCodec;
  private VideoCodec vCodec;

  public Settings(AudioCodec aCodec, VideoCodec vCodec) {
    this.aCodec = aCodec;
    this.vCodec = vCodec;
  }

  public String toString() {
    return String.format("Settings: {%s, %s}", this.aCodec.toString(), this.vCodec.toString());
  }
}

// Аудио кодеки.
abstract class AudioCodec {
  protected int bitrate;
  public AudioCodec(int bitrate) {
    this.bitrate = bitrate;
  }

  public String toString() {
    return String.format("audio {name: %s, bitrate: %d}",
        getClass().getSimpleName(), this.bitrate);
  }
}
class MP3 extends AudioCodec {
  public MP3(int bitrate) {
    super(bitrate);
  }
}
class OGG extends AudioCodec {
  public OGG(int bitrate) {
    super(bitrate);
  }
}
class WMA extends AudioCodec {
  public WMA(int bitrate) {
    super(bitrate);
  }
}

// Видео кодеки.
abstract class VideoCodec {
  protected int bitrate;
  protected int height;
  protected int width;
  public VideoCodec(int bitrate, int height, int width) {
    this.bitrate = bitrate;
    this.height = height;
    this.width = width;
  }

  public String toString() {
    return String.format("video {name: %s, width: %d, height: %d, bitrate: %d}",
        getClass().getSimpleName(), this.width, this.height, this.bitrate);
  }
}
class MPEG4 extends VideoCodec {
  public MPEG4(int bitrate, int height, int width) {
    super(bitrate, height, width);
  }
}
class VP9 extends VideoCodec {
  public VP9(int bitrate, int height, int width) {
    super(bitrate, height, width);
  }
}
class WMV extends VideoCodec {
  public WMV(int bitrate, int height, int width) {
    super(bitrate, height, width);
  }
}
