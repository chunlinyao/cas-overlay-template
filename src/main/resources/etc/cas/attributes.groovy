import java.util.*

def Map<String, List<Object>> run(final Object... args) {
	def (username, attributes, logger, properties, appContext) = args
	logger.info("[{}]: The received username is [{}]", this.class.simpleName, username)
	return [username: [username], likes: ['banana'], another:'foobar']
}
