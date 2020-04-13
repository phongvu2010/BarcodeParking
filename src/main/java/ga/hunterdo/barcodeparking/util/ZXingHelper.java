package ga.hunterdo.barcodeparking.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class ZXingHelper {
	public static byte[] getBarCodeImage(String text, int width, int height) throws WriterException, IOException {
		Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

		Writer writer = new Code39Writer();
		BitMatrix bitMatrix = writer.encode(text, BarcodeFormat.CODE_39, width, height);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, "png", byteArrayOutputStream);

		return byteArrayOutputStream.toByteArray();
	}
}