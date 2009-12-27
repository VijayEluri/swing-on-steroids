/*
 * Copyright (c) 2009 Paul Merlin <paul@nosphere.org>
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
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.codeartisans.java.sos.sampleapp;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.codeartisans.java.sos.sampleapp.presentation.presenters.GreetingsPresenter;
import org.codeartisans.java.sos.sampleapp.presentation.views.GreetingsView;
import org.codeartisans.java.sos.sampleapp.presentation.views.swing.SwingGreetingsView;
import org.codeartisans.java.toolbox.guice.GuiceHelper;

/**
 * @author Paul Merlin <paul@nosphere.org>
 */
public final class SampleGuiceApp
{

    public static void main(String[] args)
    {
        GuiceHelper.enableDebugOutput();
        Injector injector = Guice.createInjector(new AbstractModule()
        {

            @Override
            protected void configure()
            {
                bind(GreetingsView.class).to(SwingGreetingsView.class);
                bind(GreetingsPresenter.class);
            }

        });
        GreetingsPresenter presenter = injector.getInstance(GreetingsPresenter.class);
        presenter.bind();
        presenter.view().reveal();

    }

}
