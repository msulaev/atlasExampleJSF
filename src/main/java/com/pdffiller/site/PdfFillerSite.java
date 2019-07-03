package com.pdffiller.site;

import com.pdffiller.page.EditorPage;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.Page;

public interface PdfFillerSite extends WebPage {
    @Page
    EditorPage editor();

    default void openEditor(String Url) {
        editor().open(Url);
    }
}
