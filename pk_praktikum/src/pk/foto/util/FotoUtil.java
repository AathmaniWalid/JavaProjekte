package pk.foto.util;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.jpeg.JpegDirectory;

import pk.foto.FotoMetadaten;

public abstract class FotoUtil {
	public static FotoMetadaten readMetadata(File photoFile)
			throws ImageProcessingException, IOException, MetadataException, NullPointerException {
		Metadata metadata = ImageMetadataReader.readMetadata(photoFile);
		Directory jpgDir = metadata.getFirstDirectoryOfType(JpegDirectory.class);
		Directory exifIfd0 = metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
		Date date = exifIfd0.getDate(ExifIFD0Directory.TAG_DATETIME, TimeZone.getDefault());

		return new FotoMetadaten(jpgDir.getInt(JpegDirectory.TAG_IMAGE_WIDTH),
				jpgDir.getInt(JpegDirectory.TAG_IMAGE_HEIGHT), exifIfd0.getString(ExifIFD0Directory.TAG_MAKE),
				exifIfd0.getString(ExifIFD0Directory.TAG_MODEL),
				LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()));
	}
}
