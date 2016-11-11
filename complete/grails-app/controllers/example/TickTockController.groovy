package example

//tag::rxjavaImports[]
import rx.Subscriber
import grails.rx.web.*
/**
 * Demo Server Sent Events Controller
 */
class TickTockController implements RxController {
//end::rxjavaImports[]

    //tag::rxStream[]
    def index() {
        rx.stream { Subscriber subscriber ->
            //tag::rxOnNext[]
            for(i in (0..5)) {
                if(i % 2 == 0) {
                    subscriber.onNext(
                        rx.render("Tick")
                    )
                }
                else {
                    subscriber.onNext(
                        rx.render("Tock")
                    )
                }                
                sleep 1000
            }
            //end::rxOnNext[]
            //tag::rxOnCompleted[]
            subscriber.onCompleted()
            //end::rxOnCompleted[]
        }
    }
    //end::rxStream[]
}
