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
package org.swing.on.steroids.swing.helpers;

import javax.swing.SwingUtilities;

import org.swing.on.steroids.swing.components.ExceptionDialog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SteroidUncaughtExceptionHandler
        implements Thread.UncaughtExceptionHandler
{

    private static final Logger LOGGER = LoggerFactory.getLogger( SteroidUncaughtExceptionHandler.class );

    @Override
    public void uncaughtException( final Thread t, final Throwable ex )
    {
        if ( SwingUtilities.isEventDispatchThread() ) {
            showException( ex );
        } else {
            SwingUtilities.invokeLater( new Runnable()
            {

                @Override
                public void run()
                {
                    showException( ex );
                }

            } );
        }


    }

    private void showException( Throwable ex )
    {
        LOGGER.error( "UncaughtException handled: " + ex.getMessage(), ex );
        ExceptionDialog.showException( ex );
    }

}
