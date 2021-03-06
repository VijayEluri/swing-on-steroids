/*
 * Copyright (c) 2009, Paul Merlin. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.codeartisans.java.sos.sampleapp;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;

import org.swing.on.steroids.guice.GuiceHelper;
import org.codeartisans.java.sos.sampleapp.domain.DefaultGreetService;
import org.codeartisans.java.sos.sampleapp.domain.GreetService;
import org.codeartisans.java.sos.sampleapp.presentation.presenters.GreetingsPresenter;
import org.codeartisans.java.sos.sampleapp.presentation.views.GreetingsView;
import org.codeartisans.java.sos.sampleapp.presentation.views.swing.SwingGreetingsView;
import org.swing.on.steroids.threading.DefaultWorkQueue;
import org.swing.on.steroids.threading.WorkQueue;
import org.swing.on.steroids.swing.SwingWrappersFactory;
import org.swing.on.steroids.swing.annotations.EventDispatchThread;
import org.swing.on.steroids.swing.annotations.EventDispatchThreadInterceptor;
import org.swing.on.steroids.swing.helpers.SwingHelper;

public final class SampleGuiceApp
{

    public static void main( String[] args )
    {
        SwingHelper.initSafeSwing();
        GuiceHelper.enableDebugOutput();
        Injector injector = Guice.createInjector( new AbstractModule()
        {

            @Override
            protected void configure()
            {
                bind( String.class ).annotatedWith( Names.named( WorkQueue.NAME ) ).toInstance( "SamplePresentationWorkQueue" );
                bind( Integer.class ).annotatedWith( Names.named( WorkQueue.SIZE ) ).toInstance( 2 );
                bind( WorkQueue.class ).to( DefaultWorkQueue.class ).in( Singleton.class );
                bind( SwingWrappersFactory.class );
                bind( GreetingsView.class ).to( SwingGreetingsView.class );
                bind( GreetService.class ).to( DefaultGreetService.class ).in( Singleton.class );
                bind( GreetingsPresenter.class );
                bindInterceptor( Matchers.any(), Matchers.annotatedWith( EventDispatchThread.class ), new EventDispatchThreadInterceptor() );
            }

        } );
        GreetingsPresenter presenter = injector.getInstance( GreetingsPresenter.class );
        presenter.bind();
        presenter.view().reveal();

    }

}
