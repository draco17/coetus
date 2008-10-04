class UtilTagLib {
	static namespace = "util"
	def authenticateService
	
	def checkUsers = { attrs ->
		checkDefaultRole()
		if(Person.count() == 0) {
			out << 'Coetu no esta protegido, debes agregar a un suario, hacerlo adiministrador y proteger el sitio.'
		}
	}
	
	def verifyUserManager = { attrs, body ->
		def event = attrs.event
		if(event.createdBy.id==authenticateService.userDomain().id) {
			out << body()
		}
	}
	
	private void checkDefaultRole() {
		if(Authority.count() == 0) {
			new Authority(description:"Usuario del Sistema", authority:"ROLE_USER").save()
			new Authority(description:"Administrador del Sistema", authority:"ROLE_ADMIN").save()
			new Authority(description:"Orador", authority:"ROLE_SPEAKER").save()
			new Authority(description:"Administrador de eventos", authority:"ROLE_MANAGER").save()
			log.debug('Roles created')
		}
	}
}
