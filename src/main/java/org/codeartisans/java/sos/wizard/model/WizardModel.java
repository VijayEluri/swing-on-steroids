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
package org.codeartisans.java.sos.wizard.model;

/**
 * FIXME See if we really need theses methods ...
 * 
 * @author Paul Merlin
 */
public interface WizardModel
{

    /**
     * Indicates whether or not the Wizard is complete.
     * @return <code>true</code> if the {@link WizardModel} is complete, <code>false</code> otherwise
     */
    boolean isComplete();

    /**
     * Called when the Wizard is cancelled.
     * Should fully reset the model so that the {@link WizardPresenter} can be run again.
     */
    void reset();

}
