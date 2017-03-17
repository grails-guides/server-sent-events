package example

//tag::rxjavaImports[]
import rx.*
import grails.rx.web.*
import java.util.concurrent.TimeUnit
/**
 * Demo Server Sent Events Controller
 */
class TickTockController implements RxController {
//end::rxjavaImports[]

    //tag::rxStream[]
    def index() {
        rx.stream { Observer observer ->
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
            observer.onCompleted()
            //end::rxOnCompleted[]
        }
    }
    //end::rxStream[]

    //tag::interval[]
    def example() {
        int i = 0
        rx.stream(Observable
                    .interval(1, TimeUnit.SECONDS)
                    .map {
            i++  
            if(i % 2 == 0) {
                rx.render("Tick")
            }
            else {
                rx.render("Tock")
            }                         
        })        
    }
    //end::interval[]
}
