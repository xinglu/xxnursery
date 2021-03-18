package com.nursery.utils;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.List;

/**
 * author:MeiShiQiang
 * Date:2021/3/16 | Time:15:11
 */
public class POIUtils {

    /**
     * 获取简单文字
     *
     * @param path
     * @return
     * @throws IOException
     * @throws OpenXML4JException
     * @throws XmlException
     */
    public static String readDoc(String path) throws IOException, OpenXML4JException, XmlException {
        String result = "";
        if (path.endsWith(".doc")) { //会报错,没解决
            XWPFDocument xwpfDocument = new XWPFDocument(new FileInputStream(path));
            XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(xwpfDocument);
            result = xwpfWordExtractor.getText();
        } else if (path.endsWith(".docx")) { //可以使用
            OPCPackage opcPackage = POIXMLDocument.openPackage(path);
            XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(opcPackage);
            result = xwpfWordExtractor.getText();
            opcPackage.close();
        } else {
            result = "";
        }
        return result;
    }


    /**
     * doc 转换 html
     *
     * @param path      C:\\Users\\NANNAN\\Desktop\\梅士强\\个人简历\\梅士强-java开发工程师简历.doc
     * @param htmlPath  C:\\Users\\NANNAN\\Desktop\\6\\新建文件夹\\全球最贵域名.html
     * @param imagePath C:\\Users\\NANNAN\\Desktop\\6\\新建文件夹\\image\\"
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws TransformerException
     */
    public static void docToHtml(String path, String htmlPath, String imagePath) throws IOException, ParserConfigurationException, TransformerException {
        HWPFDocument wordDocument = new HWPFDocument(new FileInputStream(path));
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(document);
        wordToHtmlConverter.setPicturesManager((content, pictureType, name, width, height) -> {
            try {
                FileOutputStream out = new FileOutputStream(imagePath + name);
                out.write(content);
            } catch (Exception e) {
                e.getMessage();
            }
            return "image/" + name;
        });
        wordToHtmlConverter.processDocument(wordDocument);
        Document htmlDocument1 = wordToHtmlConverter.getDocument();
        DOMSource domSource = new DOMSource(htmlDocument1);
        StreamResult streamResult = new StreamResult(new File(htmlPath));
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "html");
        transformer.transform(domSource, streamResult);
    }

    /**
     * @param path      C:\\Users\\NANNAN\\Desktop\\梅士强\\个人简历\\梅士强-java开发工程师简历.doc
     * @param imagePath C:\\Users\\NANNAN\\Desktop\\6\\新建文件夹\\image\\
     * @return 放回html  content
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws TransformerException
     */
    public static String docHtmlContent(String path, String imagePath) throws IOException, ParserConfigurationException, TransformerException {
        InputStream input = new FileInputStream(path);
        HWPFDocument wordDocument = new HWPFDocument(input);
        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
                DocumentBuilderFactory.newInstance().newDocumentBuilder()
                        .newDocument());
        wordToHtmlConverter.setPicturesManager(new PicturesManager() {
            public String savePicture(byte[] content, PictureType pictureType,
                                      String suggestedName, float widthInches, float heightInches) {
                return suggestedName;
            }
        });
        wordToHtmlConverter.processDocument(wordDocument);
        List pics = wordDocument.getPicturesTable().getAllPictures();
        if (pics != null) {
            for (int i = 0; i < pics.size(); i++) {
                Picture pic = (Picture) pics.get(i);
                try {
                    pic.writeImageContent(new FileOutputStream(imagePath
                            + pic.suggestFullFileName()));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        Document htmlDocument = wordToHtmlConverter.getDocument();
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(outStream);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer serializer = tf.newTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty(OutputKeys.METHOD, "html");
        serializer.transform(domSource, streamResult);
        String content = new String(outStream.toByteArray(), "utf-8");
        outStream.close();
        return content;

    }



    /**
     * @param sourceFileName "C:\\Users\\NANNAN\\Desktop\\6\\新建文件夹\\Linux权限管理.docx";
     * @param targetFileName "C:\\Users\\NANNAN\\Desktop\\6\\新建文件夹\\Linux权限管理.html";
     * @param imagePathStr   "C:\\Users\\NANNAN\\Desktop\\6\\新建文件夹\\image";
     * @throws Exception
     */
    public static void docxToHtml(String sourceFileName, String targetFileName,String imagePathStr) throws Exception {

        OutputStreamWriter outputStreamWriter = null;
        try {
            XWPFDocument document = new XWPFDocument(new FileInputStream(sourceFileName));
            XHTMLOptions options = XHTMLOptions.create();
            // 存放图片的文件夹
            options.setExtractor(new FileImageExtractor(new File(imagePathStr)));
            // html中图片的路径
            options.URIResolver(new BasicURIResolver("image"));
            FileOutputStream fileOutputStream = new FileOutputStream(targetFileName);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf-8");
            XHTMLConverter xhtmlConverter = (XHTMLConverter) XHTMLConverter.getInstance();
            xhtmlConverter.convert(document, outputStreamWriter, options);

        } finally {
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
        }
    }
}
