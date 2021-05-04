package test;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;

/**
 * Created by fengjie.luo on 2016/6/22.
 */
public class MatrixToImageWriter {
    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;

    private MatrixToImageWriter() {
    }

    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }

    public static void writeToFile(BitMatrix matrix, String format, File file) throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, file)) {
            throw new IOException("Could not write an image of format " + format + " to " + file);
        }
    }

    public static void writeToStream(BitMatrix matrix, String format, OutputStream stream) throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, stream)) {
            throw new IOException("Could not write an image of format " + format);
        }
    }

    public static void main(String[] args) throws Exception {
        String text = "weixin://wxpay/bizpayurl?pr=yMm1kNu";
        int width = 300;
        int height = 300;
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");//内容所使用编码
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);

        File outputFile = new File("D:\\test\\生成普通二维码.jpg");
        //File.separator
        String format = "jpg";//二维码的图片格式
        MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);

    }
}
