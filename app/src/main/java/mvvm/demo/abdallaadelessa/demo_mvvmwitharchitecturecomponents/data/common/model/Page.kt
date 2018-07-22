package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.common.model

class Page<E>(val data : List<E>?) {
  val isEmpty  get()= data== null || data.isEmpty();
}