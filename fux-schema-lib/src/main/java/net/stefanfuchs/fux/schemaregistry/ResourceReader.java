package net.stefanfuchs.fux.schemaregistry;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author fuchsste
 */
class ResourceReader {

    /**
     * Returns a map of filename and file content (serialized as string)
     *
     * @return
     * @throws IOException
     */
    public Map<String, String> getRessourceNameList() throws IOException {
        return getRessourceNameList("");
    }

    /**
     * Returns a map of filename and file content (serialized as string)
     *
     * @param fileExtensionFilter only file with file extension separated by "."
     * @return
     * @throws IOException
     */
    public Map<String, String> getRessourceNameList(String fileExtensionFilter) throws IOException {
        final String fileExtensionDelimiter = fileExtensionFilter.startsWith(".") ? "" : ".";

        ClassLoader cl = this.getClass().getClassLoader();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(cl);
        Resource[] resources = resolver.getResources("**");
        Map<String, String> result = new HashMap<>();
        for (Resource resource : resources) {
            String url = resource.getURL().toString();
            if (fileExtensionFilter.length() == 0 || url.endsWith(fileExtensionDelimiter + fileExtensionFilter)) {
                result.put(url, getFile(resource.getInputStream()));
            }
        }
        return result;
    }

    private String getFile(InputStream inputStream) throws IOException {
        return new BufferedReader(new InputStreamReader(inputStream))
                .lines()
                .collect(Collectors.joining("\n"));
    }
}
