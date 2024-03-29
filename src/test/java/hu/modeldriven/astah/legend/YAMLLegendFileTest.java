package hu.modeldriven.astah.legend;

import hu.modeldriven.astah.legend.ui.model.Legend;
import hu.modeldriven.astah.legend.ui.model.LegendFile;
import hu.modeldriven.astah.legend.ui.model.impl.YAMLLegendFile;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class YAMLLegendFileTest {

    @Test
    public void testLoad() throws Exception{

        File file = new File(getClass().getClassLoader().getResource("test.yaml").getFile());

        LegendFile yamlLegendFile = new YAMLLegendFile(file);
        Legend legend = yamlLegendFile.read();
        Assert.assertNotNull(legend);
    }

}
