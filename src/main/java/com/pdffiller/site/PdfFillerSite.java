package com.pdffiller.site;

import com.pdffiller.page.EditorPage;
import com.pdffiller.page.LoginPage;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.WebSite;
import io.qameta.atlas.webdriver.extension.Page;


public interface PdfFillerSite extends WebPage {
    @Page
    EditorPage editor();

    @Page
    LoginPage login();

    default void openEditor(String Url) {
        editor().open(Url);
    }
}
