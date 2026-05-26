/**
 * JSastrawi is licensed under The MIT License (MIT)
 *
 * Copyright (c) 2015 Andy Librian
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package jsastrawi.cli;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import jsastrawi.cli.output.Output;
import jsastrawi.cli.output.SystemOutput;
import jsastrawi.morphology.DefaultLemmatizer;
import jsastrawi.morphology.Lemmatizer;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Handler of lemmatize command
 */
public class LemmatizeCmd {

    private final Output output;

    /**
     * Constructor
     *
     * @param output Output object. It is used to print messages.
     */
    public LemmatizeCmd(Output output) {
        this.output = output;
    }

    /**
     * Constructor
     */
    public LemmatizeCmd() {
        this.output = new SystemOutput();
    }

    /**
     * @return output object.
     */
    public Output getOutput() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Handle lemmatize command
     *
     * @param args arguments
     * @throws IOException IOException
     */
    public void handle(String[] args) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Options buildOptions() {
        Options options = new Options();
        options.addOption(Option.builder("d").longOpt("dictionary").desc("The path of dictionary file. If not specified, the default dictionary will be used.").hasArg().argName("FILE").build());
        options.addOption(Option.builder("tb").longOpt("testbed").desc("Run a testbed against a csv file. The expected format is word,lemma.").hasArg().argName("FILE").build());
        options.addOption("h", "help", false, "This help.");
        return options;
    }

    private Set<String> getDictionaryFromFile(String file) throws FileNotFoundException, IOException {
        Set<String> dictionary = new HashSet<>();
        File f = new File(file);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        fillSet(dictionary, br);
        return dictionary;
    }

    private Set<String> getDefaultDictionary() throws IOException {
        Set<String> dictionary = new HashSet<>();
        InputStream in = LemmatizeCmd.class.getResourceAsStream("/root-words.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        fillSet(dictionary, br);
        return dictionary;
    }

    private void fillSet(Set<String> set, BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            set.add(line);
        }
    }

    void runTestBed(Map<String, String> testbed, Lemmatizer lemmatizer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Map<String, String> scanTestBedMapFromFile(String filePath) throws FileNotFoundException, IOException {
        Map<String, String> map = new HashMap<>();
        File f = new File(filePath);
        FileReader fr = new FileReader(f);
        BufferedReader reader = new BufferedReader(fr);
        String line;
        while ((line = reader.readLine()) != null) {
            String[] split = line.split(",");
            if (split.length >= 2) {
                map.put(split[0], split[1]);
            }
        }
        return map;
    }
}
