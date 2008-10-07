/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
class ProfileController {
	def authenticateService
	def index = {
		redirect(action: my, params: params)
	}
	def my = {
		[person:authenticateService.userDomain()]
	}
	def update = {
        def person = Person.get( params.id )
		//println(person)
        if(person) {
            person.properties = params
			//println(person)
            if(!person.hasErrors() && person.save(flush:true)) {
				//println(person)
                flash.message = "Usuario : ${person.username} actualizado ...!!!"
                flash.args = [params.id]
                flash.defaultMessage = "Usuario : ${person.username} actualizado ...!!!"
                render(view:'my',model:[person:person])
            }
            else {
                render(view:'my',model:[person:person])
            }
        }
        else {
            flash.message = "person.not.found"
            flash.args = [params.id]
            flash.defaultMessage = "Person not found with id ${params.id}"
            redirect(action:my, params: params)
        }
    }
}
