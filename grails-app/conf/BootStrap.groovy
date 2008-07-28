import org.grails.plugins.springsecurity.service.AuthenticateService

class BootStrap {
	AuthenticateService authenticateService	
	
	def init = { servletContext ->
		
		if(Authority.count() == 0) {
			new Authority(description:"Usuario del Sistema", authority:"ROLE_USER").save()
			new Authority(description:"Administrador del Sistema", authority:"ROLE_ADMIN").save()
			new Authority(description:"Orador", authority:"ROLE_SPEAKER").save()
		}
		
		if(Requestmap.count() == 0) {
			new Requestmap(url:"/event/**", configAttribute:"ROLE_ADMIN").save()
			new Requestmap(url:"/events/**", configAttribute:"IS_AUTHENTICATED_ANONYMOUSLY").save()
			new Requestmap(url:"/myevents/**", configAttribute:"ROLE_USER").save()
			new Requestmap(url:"/person/**", configAttribute:"ROLE_ADMIN").save()
			new Requestmap(url:"/role/**", configAttribute:"ROLE_ADMIN").save()
			new Requestmap(url:"/talk/**", configAttribute:"ROLE_ADMIN").save()
			new Requestmap(url:"/user/**", configAttribute:"ROLE_ADMIN").save()
		}
				
		def evento = new Event()
		def domingo = new Person()
		def andres = new Person()
		
		def grailsT = new Talk()
		def groovyT = new Talk()
		def compartida = new Talk()
		
		if(Event.count() == 0) {
			println "Agregando evento prueba"
			
			evento = new Event(name:"Evento Prueba", description:"Evento dummy", location:"Por alla", status:Status.OPEN)
			evento.save()
		}
		
		if(Person.count() == 0) {
			
			compartida = new Talk(event:evento, title:"Presentacion del GUG", summary:"Chido", location:"Por alla", status:Status.OPEN)
			compartida.save()
			
			groovyT = new Talk(event:evento, title:"Introduccion a Groovy", summary:"Chido", location:"Por alla", status:Status.OPEN)
			groovyT.save()
			
			grailsT = new Talk(event:evento, title:"Introduccion a Grails", summary:"Chido", location:"Por alla", status:Status.OPEN)
			grailsT.save()
			
			String defaultPasword = authenticateService.passwordEncoder("root")
			println defaultPasword
			
			domingo = new Person(username:"domix",userRealName:"Domingo Suarez", passwd:defaultPasword, email:"domingo.suarez@gmail.com", company:"Bursatec", bio:"Chido", blog:"http://www.domix.org")
			domingo.save()
			
			andres = new Person(username:"aalmiray",userRealName:"Andres Almiray", passwd:defaultPasword, email:"aalmiray@yahoo.com", company:"Oracle", bio:"Chido", blog:"http://www.jroller.com/aalmiray/")
			andres.save()
			
			compartida.addToSpeakers(andres)
			compartida.addToSpeakers(domingo)
			compartida.save()
			
			groovyT.addToSpeakers(andres)
			groovyT.save()
			
			grailsT.addToSpeakers(domingo)
			grailsT.save()
			
			
			def usr1 = new Person(username:"jkings",userRealName:"Juanelo", passwd:defaultPasword, email:"reyesmjm@gmail.com", company:"IFE", bio:"Chido", blog:"http://www.reyesmjm.org")
			usr1.save()
			def usr2 = new Person(username:"jordi",userRealName:"Jorge", passwd:defaultPasword, email:"jorge@gmail.com", company:"IFE", bio:"Chido", blog:"http://www.reyesmjm.org")
			usr2.save()
			
			
			def asistente1 = new Attendee(person:usr1, event:evento)
			asistente1.save()
			
			def asistente2 = new Attendee(person:usr2, event:evento)
			asistente2.save()
			
			asistente1.addToTalks(compartida)
			asistente1.addToTalks(groovyT)
			asistente1.save()
			
			asistente2.addToTalks(compartida)
			asistente1.addToTalks(grailsT)
			asistente2.save()
			
		}
     }
     def destroy = {
     }
} 