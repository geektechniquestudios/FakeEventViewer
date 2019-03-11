package itemPopulation;

import javafx.beans.binding.Bindings;
import javafx.scene.Node;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Region;

public final class TitledPaneUtils {

    public static void putArrowOnRight(TitledPane pane) {
        Region title = (Region) pane.lookup(".title");
        Region arrow = (Region) title.lookup(".arrow-button");
        Node text = title.lookup(".text");

        arrow.translateXProperty().bind(Bindings.createDoubleBinding(() -> {
            double titleWidth = title.getWidth();
            double arrowWidth = arrow.getWidth();
            double rightInset = title.getPadding().getRight();
            double leftInset = title.getPadding().getLeft();
            return titleWidth - arrowWidth - rightInset - leftInset;
        }, title.widthProperty(), title.paddingProperty(), arrow.widthProperty()));

        text.translateXProperty().bind(Bindings.createDoubleBinding(() -> {
            double leftInset = title.getPadding().getLeft();
            double textLayout = text.getLayoutX();
            return leftInset - textLayout;
        }, title.paddingProperty(), text.layoutXProperty()));
    }

    // prevent instantiation
    private TitledPaneUtils() {}

}