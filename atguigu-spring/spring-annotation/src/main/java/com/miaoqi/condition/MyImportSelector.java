package com.miaoqi.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

    // 返回值就是要导入的组件的全类名
    // AnnotationMetadata: 当前标注@Import注解的类的所有信息
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.miaoqi.bean.Blue", "com.miaoqi.bean.Yellow"};
    }
}
