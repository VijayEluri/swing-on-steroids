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
package org.codeartisans.java.sos.wizard.presenters;

import org.codeartisans.java.sos.wizard.model.WizardPageID;
import org.codeartisans.java.sos.wizard.model.SignupWizardModel;
import org.codeartisans.java.sos.wizard.views.WelcomePageView;

public class WelcomePagePresenter
        extends WizardPagePresenter<SignupWizardModel, WelcomePageView>
{

    public static final WizardPageID PAGEID = new WizardPageID();

    public WelcomePagePresenter( WelcomePageView view )
    {
        super( view );
    }

    @Override
    public WizardPageID wizardPageID()
    {
        return PAGEID;
    }

    @Override
    public String title()
    {
        return "Welcome";
    }

    @Override
    public void onPageAdded( WizardPageHelper<SignupWizardModel> helper )
    {
    }

    @Override
    protected void onBind()
    {
    }

    @Override
    protected void onUnbind()
    {
    }

}
