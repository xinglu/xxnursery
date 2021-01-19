package com.nursery.utils;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * file
 * extensions
 */
@Component
public class FileUtil {
    //图片扩展
    public static final List<String> IMAGE_EXTENSIONS = Arrays.asList(".jpg", ".jpeg", ".png");
    //文档扩展
    public static final List<String> DOCUMENT_EXTENSIONS = Arrays.asList(".doc", ".docx", ".pdf");
}