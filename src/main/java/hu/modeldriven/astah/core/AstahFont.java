package hu.modeldriven.astah.core;

import com.change_vision.jude.api.inf.presentation.INodePresentation;

import java.awt.Font;

public class AstahFont {

    private final Font font;

    public AstahFont(Font font) {
        this.font = font;
    }

    public void apply(INodePresentation presentation) {
        // FIXME due to Astah errors it is not possible to set font properties,
        // when it is fixed the code can be adjusted
//        try {
//            presentation.setProperty(PresentationPropertyConstants.Key.FONT_NAME, font.getFamily());
//            presentation.setProperty(PresentationPropertyConstants.Key.FONT_SIZE, String.valueOf(font.getSize()));
//            presentation.setProperty(PresentationPropertyConstants.Key.FONT_STYLE, convertFontStyleToString(font.getStyle()));
//        } catch (Exception e) {
//            // Display the error trace but don't stop the execution
//            e.printStackTrace();
//        }
    }

    private String convertFontStyleToString(int fontStyle) {
        switch (fontStyle) {
            case Font.PLAIN:
                return "PLAIN";
            case Font.BOLD:
                return "BOLD";
            case Font.ITALIC:
                return "ITALIC";
            case Font.BOLD | Font.ITALIC:
                return "BOLDITALIC";
            default:
                return "Unknown";
        }
    }
}
