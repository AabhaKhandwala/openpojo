/*
 * Copyright (c) 2010-2018 Osman Shoukry
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.openpojo.validation.rule.impl;

import com.openpojo.validation.CommonCode;
import com.openpojo.validation.rule.Rule;
import com.openpojo.validation.rule.impl.sampleclasses.GetterDoesExistClass;
import com.openpojo.validation.rule.impl.sampleclasses.GetterDoesntExistClass;
import org.junit.Test;

/**
 * @author oshoukry
 */
public class GetterMustExistRuleTest {
  private Class<?>[] failClasses = new Class<?>[] { GetterDoesntExistClass.class };
  private Class<?>[] passClasses = new Class<?>[] { GetterDoesExistClass.class };
  private Rule rule = new GetterMustExistRule();

  @Test
  public void testEvaluate() {
    CommonCode.shouldPassRuleValidation(rule, passClasses);
    CommonCode.shouldFailRuleValidation(rule, failClasses);
  }

  @Test
  public void shouldIgnoreSyntheticFields() {
    CommonCode.shouldPassRuleValidation(rule, AClassWithSyntheticField.class);
  }

  private class AClassWithSyntheticField {
  }
}
