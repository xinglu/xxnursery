package com.nursery.nurserymanage2;

import lombok.SneakyThrows;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLPropertiesTextExtractor;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
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
import org.junit.jupiter.api.Test;
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

/**
 * author:MeiShiQiang
 * Date:2021/3/16 | Time:16:23
 */

public class PoiWordToHtml3 {
    private String mkFile = "D:\\wordHtml\\";
    private String mkImage = "D:\\wordHtml\\image\\";

    //doc 转  html
    @Test
    public void testDoc() throws IOException, ParserConfigurationException, TransformerException {
        String filePath = "C:\\Users\\NANNAN\\Desktop\\6\\新建文件夹\\全球最贵域名大全.doc";
        String htmlPath = mkFile+"2.html";
        File file = new File(mkFile);
        File imagefile = new File(mkImage);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!imagefile.exists()){
            imagefile.mkdirs();
        }
        HWPFDocument hwpfDocument = new HWPFDocument(new FileInputStream(filePath));
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        WordToHtmlConverter converter = new WordToHtmlConverter(document);
        //同一个文档中的招聘会覆盖
        converter.setPicturesManager(new PicturesManager() {
            @SneakyThrows
            @Override
            public String savePicture(byte[] bytes, PictureType pictureType, String s, float v, float v1) {
                FileOutputStream out = new FileOutputStream(mkImage+s);
                out.write(bytes);
                return "image/"+s;
            }
        });
        converter.processDocument(hwpfDocument);
        Document htmlDocument = converter.getDocument();
        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(new File(htmlPath));
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING,"utf-8");
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        transformer.setOutputProperty(OutputKeys.METHOD,"html");
        transformer.transform(domSource,streamResult);

        System.out.println("returnPath:" + htmlPath);
    }


    //docx  转   html
    @Test
    public void testDocx() throws IOException {
        String filePath = "C:\\Users\\NANNAN\\Desktop\\6\\新建文件夹\\Linux权限管理.docx";
        String htmlPath = mkFile+"Linux权限管理.html";
        File file = new File(mkFile);
        File imagefile = new File(mkImage);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!imagefile.exists()){
            imagefile.mkdirs();
        }
        XWPFDocument xwpfDocument = new XWPFDocument(new FileInputStream(filePath));
        XHTMLOptions xhtmlOptions = XHTMLOptions.create();
        //存放图片的文件夹
        xhtmlOptions.setExtractor(new FileImageExtractor(new File(mkImage)));
        //html中图片的路径
        xhtmlOptions.URIResolver(new BasicURIResolver("image"));
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(htmlPath), "utf-8");
        XHTMLConverter converter = (XHTMLConverter) XHTMLConverter.getInstance();
        converter.convert(xwpfDocument,outputStreamWriter,xhtmlOptions);
        outputStreamWriter.close();
    }


    //阅读doc的文本内容
    @Test
    public void readDoc() throws IOException, OpenXML4JException, XmlException {
        String path = "C:\\Users\\NANNAN\\Desktop\\6\\新建文件夹\\阿里云绑定主机域名.docx";
        OPCPackage opcPackage = POIXMLDocument.openPackage(path);
        XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(opcPackage);
        POIXMLPropertiesTextExtractor metadataTextExtractor = xwpfWordExtractor.getMetadataTextExtractor();
        String text1 = metadataTextExtractor.getText();
        System.out.println(text1);
        String text = xwpfWordExtractor.getText();
        System.out.println(text);
        opcPackage.close();
    }

    //阅读docx的文本内容
    @Test
    public void readDocx() throws IOException {
        String path = "C:\\Users\\NANNAN\\Desktop\\6\\新建文件夹\\全球十大最贵域名.doc";
        XWPFDocument xwpfDocument = new XWPFDocument(new FileInputStream(path));
        XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(xwpfDocument);
        System.out.println(xwpfWordExtractor.getText());
    }
}
