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
package jsastrawi.tokenization;

import java.util.LinkedList;
import java.util.List;
import jsastrawi.tokenization.analyzer.Alphanumeric;
import jsastrawi.tokenization.analyzer.Analysis;
import jsastrawi.tokenization.analyzer.Analyzer;
import jsastrawi.tokenization.analyzer.Hyphen;
import jsastrawi.tokenization.analyzer.Model;
import jsastrawi.tokenization.analyzer.Punctuation;
import jsastrawi.tokenization.analyzer.Whitespace;

public final class HeuristicTokenizer implements Tokenizer {

    private final List<Analyzer> analyzers;

    //private EntityFinder entityFinder;
    public HeuristicTokenizer() {
        analyzers = new LinkedList<>();
        analyzers.add(new Alphanumeric());
        analyzers.add(new Whitespace());
        analyzers.add(new Punctuation());
        analyzers.add(new Hyphen());
    }

    public List<Analyzer> getAnalyzers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void addAnalyzer(Analyzer a) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final String[] tokenize(String text) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
