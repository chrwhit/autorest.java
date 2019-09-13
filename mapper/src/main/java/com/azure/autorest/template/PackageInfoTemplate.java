package com.azure.autorest.template;


// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for license information.


import com.azure.autorest.extension.base.plugin.JavaSettings;
import com.azure.autorest.model.clientmodel.PackageInfo;
import com.azure.autorest.model.javamodel.JavaFile;

/**
 Writes a PackageInfo to a JavaFile.
*/
public class PackageInfoTemplate implements IJavaTemplate<PackageInfo, JavaFile>
{
    private static PackageInfoTemplate _instance = new PackageInfoTemplate();
    public static PackageInfoTemplate getInstance()
    {
        return _instance;
    }

    private PackageInfoTemplate()
    {
    }

    public final void Write(PackageInfo packageInfo, JavaFile javaFile)
    {
        JavaSettings settings = JavaSettings.getInstance();
        if (!tangible.StringHelper.isNullOrEmpty(settings.getFileHeaderText()))
        {
            javaFile.LineComment(settings.getMaximumJavadocCommentWidth(), (comment) ->
            {
                    comment.Line(settings.getFileHeaderText());
            });
            javaFile.Line();
        }

        javaFile.JavadocComment(settings.getMaximumJavadocCommentWidth(), (comment) ->
        {
                for (String desc : packageInfo.getDescription().split(java.util.regex.Pattern.quote(String.valueOf(new char[] {'\r', '\n'})), -1))
                {
                    comment.Description(desc);
                }
        });

        javaFile.Package(packageInfo.Package);
    }
}