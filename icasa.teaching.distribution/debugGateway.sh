#!/bin/sh
# Copyright 2010-2011 Université Joseph Fourier
# 
#  Licensed under the Apache License, Version 2.0 (the "License");
#  you may not use this file except in compliance with the License.
#  You may obtain a copy of the License at
#  
#    http://www.apache.org/licenses/LICENSE-2.0
#  
#  Unless required by applicable law or agreed to in writing, software
#  distributed under the License is distributed on an "AS IS" BASIS,
#  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#  See the License for the specific language governing permissions and
#  limitations under the License.
echo "Starting the gateway with remote debugger connection (on port 8000)"
echo "The execution is suspended until the debugger is connected"
java -Dchameleon.home=. -Xdebug -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=y -jar bin/chameleon-core.jar --interactive
