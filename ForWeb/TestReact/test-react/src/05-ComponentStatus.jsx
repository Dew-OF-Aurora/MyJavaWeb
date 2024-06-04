import React from 'react';
class TestComponent extends React.Component {
  //常规函数绑定this
  constructor(props) {
    super(props);
    this.changestate = this.changestate.bind(this);
  }

  //定义组件状态
  state = {
    count: 0,
    list: [1, 2, 3],
    person: {
      name: 'jack',
      age: 18,
    },
  };
  //常规函数，非箭头函数
  changestate() {
    //如果要修改组件状态，不能通过赋值修改，必须使用setState方法
    this.setState({
      count: this.state.count + 1,
      list: [...this.state.list, 4],
      person: {
        ...this.state.person,
        // 覆盖原来的属性 就可以达到修改对象中属性的目的
        name: 'rose',
      },
    });
  }
  //类组件返回
  render() {
    return (
      <div>
        {this.state.count}
        <button onClick={this.changestate}>按钮</button>
      </div>
    );
  }
}
function ComponentStatus() {
  return <TestComponent />;
}
export default ComponentStatus;
