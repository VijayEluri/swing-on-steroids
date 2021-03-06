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
package org.swing.on.steroids.threading;

import org.qi4j.api.entity.EntityComposite;
import org.qi4j.api.property.Property;

public interface WorkQueueConfiguration
        extends EntityComposite
{

    Property<String> name();

    //@Range(min = 1, max = 65535)
    Property<Integer> size();

}
